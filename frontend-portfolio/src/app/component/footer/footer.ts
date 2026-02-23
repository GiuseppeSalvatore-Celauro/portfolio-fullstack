import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faLinkedinIn, faGithub } from '@fortawesome/free-brands-svg-icons';
import { faEnvelope } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-footer',
  imports: [FontAwesomeModule],
  templateUrl: './footer.html',
  styleUrl: './footer.css',
})
export class Footer {
  faLinkedinIn = faLinkedinIn;
  faGithub = faGithub;
  faEnvelope = faEnvelope;
}
