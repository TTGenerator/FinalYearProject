/**
 * Created by jayani on 3/30/2017.
 */
export interface Room {
  roomId:Date;
  roomName:string;
  capacity?:number;
  roomCategory:string;
  isDeleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
