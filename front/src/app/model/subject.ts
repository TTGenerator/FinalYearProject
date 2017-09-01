/**
 * Created by jayani on 3/30/2017.
 */
export interface Subject {
  sub_id:Date;
  code: string;
  name?:string;
  teacher?:string;
  duration?:string;
  maxStudents:number;
  is_deleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
