/**
 * Created by jayani on 3/29/2017.
 */
import {Injectable} from '@angular/core';
import {RoomCategory} from "../../../model/room-category";

@Injectable()
export class RoomsService {
  private _roomsList = [
    {
      room_id: new Date(),
      name:'SR1',
      capacity: 50,
      category: RoomCategory[RoomCategory.SR],
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      room_id: new Date(),
      name:'DO1',
      capacity: 750,
      category: RoomCategory[RoomCategory.DO],
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      room_id: new Date(),
      name:'LR21',
      capacity: 75,
      category: RoomCategory[RoomCategory.LR],
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      room_id: new Date(),
      name:'Lab',
      capacity: 50,
      category: RoomCategory[RoomCategory.LAB],
      deleted: false,
      isChecked: false,
      isActive: false
    }
  ];

  getRoomsList() {
    return this._roomsList;
  }
}

