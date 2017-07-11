/**
 * Created by jayani on 3/30/2017.
 */
export interface Room {
  room_id:string;
  room_name:string;
  capacity?:number;
  room_category:string;
  is_deleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
