import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  img_pathUrl(event: Event): void {
    const input = event.target as HTMLInputElement;
    const file = input.files?.[0];
    if (!file) return;

    const url = (window.URL ? URL : webkitURL).createObjectURL(file);
    const profileImage = document.getElementById('profileImage');

    if (profileImage) {
      profileImage.style.backgroundImage = `url(${url})`;
    }

    const reader = new FileReader();
    reader.onload = this.readImage;
    reader.readAsDataURL(file);
  }

  private readImage(e: ProgressEvent<FileReader>): void {
    const profileUrl = e.target?.result as string;
    const profileImage = document.getElementById('profileImage');

    if (profileImage) {
      profileImage.style.backgroundImage = `url(${profileUrl})`;
      profileImage.style.backgroundSize = '100% 100%';
    }
  }
}
