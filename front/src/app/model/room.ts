/**
 * Created by jayani on 3/30/2017.
 */
export interface Room {
  roomId:string;
  roomName:string;
  capacity?:number;
  roomCategory:string;
  isDeleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
