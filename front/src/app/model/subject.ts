import {colorHelper} from "../theme/theme.constants";
/**
 * Created by jayani on 3/30/2017.
 */
export interface Subject {
  code: string;
  name:string;
  teacher?:string;
  duration?:string;
  maxStudents:number;
  deleted?:boolean;
  isChecked:boolean;
  isActive:boolean;
}
