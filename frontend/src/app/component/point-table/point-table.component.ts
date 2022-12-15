import {AfterViewInit, Component, Injectable, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTable} from '@angular/material/table';
import {PointResponse} from "../../dto/point-response";
import {PointService} from "../../service/point.service";
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-point-table',
  templateUrl: './point-table.component.html',
  styleUrls: ['./point-table.component.css']
})

export class PointTableComponent implements OnInit {
  @ViewChild(MatTable) table!: MatTable<PointResponse>;
  @ViewChild(MatPaginator) paginator! : MatPaginator;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['x', 'y', 'r', 'dt', 'hit'];
  dataSource: PointResponse[] = [];

  constructor(private service: PointService) {
    console.log("im here");
  }

  ngOnInit(): void {
    this.service.getPoints().subscribe(data => {
      console.log(data);
      this.dataSource = data;
    })
  }

  addPoint(point:PointResponse) {


    this.dataSource.push(point);
    this.table.renderRows();
  }

  clearPoints() {
    this.service.clearPoints();
    this.dataSource = [];
    this.table.renderRows();
  }


}
