import { ParticipantService } from './../../services/participant.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-participant',
  templateUrl: './participant.component.html',
  styleUrls: ['./participant.component.css', '../../app.component.css'],
})
export class ParticipantComponent implements OnInit {
  @Output() newItemEvent = new EventEmitter<number[]>();

  form: FormGroup;
  participants: number[] = [];
  constructor(private participantService: ParticipantService) {
    this.form = new FormGroup({
      nom: new FormControl(''),
      prenom: new FormControl(''),
      age: new FormControl(''),
    });
  }

  ngOnInit(): void {}

  submit() {
    let participant = {
      nom: this.form.get('nom')?.value,
      prenom: this.form.get('prenom')?.value,
      age: this.form.get('age')?.value,
    };
    this.participantService.create(participant).subscribe((p) => {
      this.participants.push(p.id);
      console.log('les participants : ' + this.participants);
      this.newItemEvent.emit(this.participants);
      //localStorage.setItem('p_id', this.participants);
    });
  }
}
