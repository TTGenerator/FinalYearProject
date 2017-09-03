/**
 * Created by jayani on 3/30/2017.
 */
export interface Room {
  roomid:string;
  roomname:string;
  capacity?:number;
  room_category:string;
  is_deleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
