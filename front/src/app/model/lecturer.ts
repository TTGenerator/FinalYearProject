import {colorHelper} from "../theme/theme.constants";
/**
 * Created by maheshika on 4/02/2017.
 */
export interface Lecturer {
  id: Date;
  name:string;
  deptID:string;
  coursesCodes:string;
  email:string;
  deleted?:boolean;
  isChecked:boolean;
  isActive:boolean;
}
