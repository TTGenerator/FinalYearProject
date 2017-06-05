import {UserRole} from "../model/user-role";
export const PAGES_MENU = [
  {
    path: 'pages',
    children: [
      {
        path: 'dashboard',
        data: {
          menu: {
            title: 'Home',
            icon: 'ion-android-home',
            selected: false,
            expanded: false,
            order: 0
          }
        },
        children: [
          {
            path: 'profile',
            data: {
              menu: {
                title: 'Profile',
              }
            }
          }
        ]
      },
      {
        path: 'manage',
        data: {
          menu: {
            title: 'Manage',
            icon: 'ion-settings',
            selected: false,
            expanded: false,
            order: 600,
          },
          authorizedRoles: UserRole[UserRole.ADMIN]
        },
        children: [
          {
            path: 'lecturers',
            data: {
              menu: {
                title: 'Lecturers',
              }
            }
          },
          {
            path: 'subjects',
            data: {
              menu: {
                title: 'Subjects',
              }
            }
          },
          {
            path: 'rooms',
            data: {
              menu: {
                title: 'Rooms',
              }
            }
          }
        ]
      },
      {
        path: 'generateTT',
        data: {
          menu: {
            title: 'Generate TT',
            icon: 'ion-gear-a',
            selected: false,
            expanded: false,
            order: 650,
          },
          authorizedRoles: UserRole[UserRole.ADMIN]
        }
      },
      {
        path: 'viewTT',
        data: {
          menu: {
            title: 'View TT',
            icon: 'ion-document',
            selected: false,
            expanded: false,
            order: 650,
          }
        }
      },
      {
        path: 'lecturerPreferences',
        data: {
          menu: {
            title: 'Add Preferences',
            icon: 'ion-plus-round',
            selected: false,
            expanded: false,
            order: 650,
          },
          authorizedRoles: UserRole[UserRole.STAFF]
        }
      },
      {
        path: 'mail',
        data: {
          menu: {
            title: 'Mail',
            icon: 'ion-email',
            selected: false,
            expanded: false,
            order: 650,
          }
        }
      }
    ]
  }
];
