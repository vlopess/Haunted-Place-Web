import {ChangeDetectionStrategy, Component} from '@angular/core';
import {MatChipsModule} from '@angular/material/chips';
import {MatIcon} from "@angular/material/icon";
import {MatDialog} from '@angular/material/dialog';
import {AddSocialNetworkDialogComponent} from "../add-social-network-dialog/add-social-network-dialog.component";
import {MatButtonModule} from "@angular/material/button";
import {NgClass, NgForOf} from "@angular/common";
import {SocialNetwork} from "../../../models/SocialNetwork";



/**
 * @title Chips avatar
 * @description An avatar inside a chip
 */
@Component({
  selector: 'chip-social-network',
  templateUrl: 'chip-social-network.component.html',
  styleUrl: 'chip-social-network.component.css',
  standalone: true,
  imports: [MatButtonModule, MatChipsModule, MatIcon, NgForOf, NgClass],
})
export class ChipSocialNetworkComponent {
  socialNetworks : SocialNetwork[] = [
    {
      id : 0,
      uid : 0,
      name : 'Instagram',
      link: 'test.com'
    },
    {
      id : 0,
      uid : 0,
      name : 'LastFm',
      link: 'test.com'
    },
    {
      id : 0,
      uid : 0,
      name : 'Test',
      link: 'test.com'
    },
  ];

  constructor(private dialog : MatDialog) {
  }
  openDialog() {
    const dialogRef = this.dialog.open(AddSocialNetworkDialogComponent, {
      enterAnimationDuration: '3000ms',
      exitAnimationDuration: '3000ms',
    });

    dialogRef.afterClosed().subscribe(value => {
      if(value != null){
        this.socialNetworks.push(value);
      }
    });
  }

  remove(socialNetwork: SocialNetwork) {
    let index = this.socialNetworks.indexOf(socialNetwork);
    if(index >= 0){
      this.socialNetworks.splice(index, 1);
    }
  }
}
