import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import {GenerateTT} from "./generateTT.component";
import {routing} from "./generateTT.routing";
import {HTTPAppService} from "../../services/HttpApp.service";
import {GeneticTimetableService} from "../../services/genetic/GeneticTimetable.service";
import {BasicTablesService} from "../../services/generateTT/basicTables.service";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    routing
  ],
  declarations: [
    GenerateTT
  ],
  providers: [
    HTTPAppService,
    GeneticTimetableService,
    BasicTablesService
  ]
})
export class GenerateTTModule {}
