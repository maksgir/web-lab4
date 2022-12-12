import {Component} from '@angular/core';
import {PointService} from "../../service/point.service";
import {FormBuilder} from "@angular/forms";
import {LoginInfo} from "../../dto/login-info";
import {PointRequestDto} from "../../dto/point-request-dto";

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

  errorMessage: string = "";

  x_values: number[] = [-4, -3, -2, -1, 0, 1, 2, 3, 4];
  y_values: number[] = [-3, -2, -1, 0, 1, 2, 3];
  r_values: number[] = [1, 1.5, 2, 2.5, 3];

  constructor(private pointService: PointService,
              private formBuilder: FormBuilder) {
  }

  onSubmit(): void {
    this.errorMessage = "";

    if (this.pointForm.value.x_value === '' || this.pointForm.value.x_value == null) {
      this.errorMessage = "X value is required";
    } else if (this.pointForm.value.y_value === '' || this.pointForm.value.y_value == null) {
      this.errorMessage = "Y value is required";
    } else if (this.pointForm.value.r_value === '' || this.pointForm.value.r_value == null) {
      this.errorMessage = "R value is required";
    } else {

      console.log('Form data: ', this.pointForm.value);

      let point = new PointRequestDto(
        +this.pointForm.value.x_value,
        +this.pointForm.value.y_value,
        +this.pointForm.value.r_value,
      );

      this.pointService.savePoint(point).subscribe(
        data => {
          console.log("New point " + data);
        },
        error => {
          console.log(error);
        }
      );


    }

  }

}
