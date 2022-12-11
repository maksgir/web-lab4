import {Component} from '@angular/core';
import {PointService} from "../../service/point.service";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-point-form',
  templateUrl: './point-form.component.html',
  styleUrls: ['./point-form.component.css']
})
export class PointFormComponent {

  pointForm = this.formBuilder.group({
    x_value: '',
    y_value: '',
    r_value: ''
  });

  x_values: number[] = [-4, -3, -2, -1, 0, 1, 2, 3, 4];

  constructor(private pointService: PointService,
              private formBuilder: FormBuilder) {
  }

  onSubmit(): void {
    // Process checkout data here
    console.log('from form: ', this.pointForm.value);
  }

}
