import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import * as JXG from "jsxgraph";
import {PointResponse} from "../../dto/point-response";
import {GeometryElement} from "jsxgraph";
import {PointService} from "../../service/point.service";
import {PointRequestDto} from "../../dto/point-request-dto";

@Component({
  selector: 'app-point-graph',
  templateUrl: './point-graph.component.html',
  styleUrls: ['./point-graph.component.css']
})
export class PointGraphComponent implements OnInit {
  points: PointResponse[] = [];

  board!: JXG.Board

  figures: GeometryElement[] = [];
  dr_points: GeometryElement[] = [];

  r: number = -1000;

  errorMessage: string = "";

  @Output() addEvent = new EventEmitter<PointResponse>();

  constructor(private service: PointService) {
  }

  ngOnInit() {
    this.r = -1000
    this.service.getPoints().subscribe(data => {
      this.points = data;
    })
    this.board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-5, 5, 5, -5], axis: true, showCopyright: false});
    // this.initFigures(3);
  }

  onClick(e: MouseEvent) {
    // @ts-ignore
    if (e.button === 2 || e.target.className === 'JXG_navigation_button') {
      return;
    }

    if (this.r != -1000) {
      let coords = this.board.getUsrCoordsOfMouse(event);
      let x = coords[0].toFixed(2);
      let y = coords[1].toFixed(2);
      let r = this.r
      console.log(x + " " + y + " " + r);

      let point = new PointRequestDto(+x, +y, r);
      this.savePoint(point)
    } else {
      this.errorMessage = "You have to choose R"
    }
  }

  addPoint(point: PointResponse) {
    this.points.push(point);
    this.refresh(point.r);
  }

  savePoint(point: PointRequestDto) {
    this.service.savePoint(point).subscribe(
      data => {
        console.log("New point " + data.dt);
        this.addEvent.emit(data);
        this.addPoint(data);
      },

      error => {
        console.log(error);
      }
    );
  }

  refresh(r: number) {
    this.r = r;
    console.log("Graph: " + r);
    this.clearBoard();
    this.drawFigures(r);
    this.drawPoints(r);
  }

  drawPoints(r: number) {
    for (const point of this.points) {
      if (point.r == r) {
        this.dr_points.push(<GeometryElement>this.createPoint(point));
      }

    }
  }

  drawFigures(r: number) {
    this.figures.push(this.createRectangle(r));
    this.figures.push(this.createTriangle(r));
    this.figures.push(this.createCircle(r));
  }

  createPoint(point: PointResponse) {
    let color = (point.hit ? "#7ce57c" : "#dc4a4a");
    return this.board.create("point", [point.x, point.y], {
      name: '', fixed: true, fillColor: color, fillOpacity: 1,
      strokewidth: 0
    });

  }

  createRectangle(r: number) {
    let rectanglePoint1 = this.board.create('point', [0, 0], {name: '', fixed: true, visible: false});
    let rectanglePoint2 = this.board.create('point', [r, 0], {name: '', fixed: true, visible: false});
    let rectanglePoint3 = this.board.create('point', [r, -r / 2], {name: '', fixed: true, visible: false});
    let rectanglePoint4 = this.board.create('point', [0, -r / 2], {name: '', fixed: true, visible: false});
    return this.board.create('polygon', [rectanglePoint1, rectanglePoint2, rectanglePoint3, rectanglePoint4],
      {fillColor: 'rgba(18,54,234,0.92)', fillOpacity: 1});
  }

  createTriangle(r: number) {
    let trianglePoint1 = this.board.create('point', [0, 0], {name: '', fixed: true, visible: false});
    let trianglePoint2 = this.board.create('point', [-r / 2, 0], {name: '', fixed: true, visible: false});
    let trianglePoint3 = this.board.create('point', [0, r / 2], {name: '', fixed: true, visible: false});
    return this.board.create('polygon', [trianglePoint1, trianglePoint2, trianglePoint3], {
      fillColor: 'rgba(18,54,234,0.92)',
      fillOpacity: 1
    });
  }

  createCircle(r: number) {
    let circlePoint1 = this.board.create('point', [-r / 2, 0], {name: '', fixed: true, visible: false});
    let circlePoint2 = this.board.create('point', [0, -r / 2], {name: '', fixed: true, visible: false});
    let centerPoint = this.board.create('point', [0, 0], {name: '', fixed: true, visible: false});

    return this.board.create('sector', [centerPoint, circlePoint1, circlePoint2],
      {fillColor: 'rgba(18,54,234,0.92)', fillOpacity: 1});
  }

  clearBoard() {
    for (const object of this.figures) {
      this.board.removeObject(object);
    }

    for (const point of this.dr_points) {
      this.board.removeObject(point);
    }
  }

}
