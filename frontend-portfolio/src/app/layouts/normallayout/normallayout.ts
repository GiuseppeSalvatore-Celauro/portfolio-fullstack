import { Component } from '@angular/core';
import { RouterOutlet } from "@angular/router";
import { Footer } from "../../component/footer/footer";
import { Navbar } from "../../component/navbar/navbar";

@Component({
  selector: 'app-normallayout',
  imports: [RouterOutlet, Footer, Navbar],
  templateUrl: './normallayout.html',
  styleUrl: './normallayout.css',
})
export class Normallayout {

}
