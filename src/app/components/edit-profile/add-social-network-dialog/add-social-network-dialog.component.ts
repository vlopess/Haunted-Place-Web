import {Component, OnInit} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {
  MatDialogActions,
  MatDialogClose,
  MatDialogContent, MatDialogRef,
  MatDialogTitle,
} from '@angular/material/dialog';
import {shakeTrigger, shownStateTrigger} from "../../../animations";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {SocialNetwork} from "../../../models/SocialNetwork";
import {NgIf} from "@angular/common";


@Component({
  selector: 'add-social-media-dialog',
  templateUrl: 'add-social-network-dialog.component.html',
  standalone: true,
  imports: [MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatButtonModule, ReactiveFormsModule, NgIf],
  animations: [
    shownStateTrigger,
    shakeTrigger
  ]
})
export class AddSocialNetworkDialogComponent implements OnInit{
  form : FormGroup = this.formBuilder.group({
    socialNetwork : ['0' , Validators.required],
    socialNetworkLink : ['', Validators.required],
    otherDescription : ['', Validators.max(50)]
  });

  showOtherInput() : boolean {
    return this.form?.value['socialNetwork'] == 'Outro';
  }

  constructor(
      private formBuilder : FormBuilder,
      private ref : MatDialogRef<AddSocialNetworkDialogComponent>
  ) {}

  ngOnInit() : void {

  }


  save(){
    let socialNetwork = <SocialNetwork>({
      id : 0,
      uid : 0,
      name : this.form?.value['socialNetwork'] == 'Outro' ? this.form?.value['otherDescription'] : this.form?.value['socialNetwork'],
      link: this.form?.value['socialNetworkLink'],
    });
    this.ref.close(socialNetwork);
  }

  close(){
    this.ref.close();
  }


}
