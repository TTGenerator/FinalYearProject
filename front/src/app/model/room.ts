/**
 * Created by jayani on 3/30/2017.
 */
export interface Room {
  room_id:Date;
  name:string;
  capacity?:number;
  category:string;
  deleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
