/**
 * Created by maheshika on 4/7/2017.
 */
export interface Preference {
  room_id:Date;
  name:string;
  capacity?:number;
  category:string;
  deleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
