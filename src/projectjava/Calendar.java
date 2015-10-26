/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JaMeSz
 */
public class Calendar {

    private class DayCalender {

        private HashMap<String, ArrayList<String>> roomAndTime;
        DAY day;

        public DayCalender(DAY day) {
            this.day = day;
            roomAndTime = new HashMap<String, ArrayList<String>>();

        }

        public void addNewScedule(String roomNum, int time, int lengthTime) {
            //Time only hr
            //Time in 24 hr format
            int end;

            if (time > 24) {
                time = time - 24;
            }
            end = time + lengthTime;

            if (end > 24) {
                end = end - 24;
            }

            String timeAdd = time + "-" + Integer.toString(end);
            
            if (hasClass(Integer.toString(time))) {
                throw new IllegalArgumentException("Invlid time... (has class)");
            } else {
                putObjects(roomNum, timeAdd);
            }
        }

        public void removeScedule(Object a) {
            roomAndTime.remove((String) a);
        }

        private void putObjects(String key, String value) {

            ArrayList<String> list = roomAndTime.get(key);
            if (list == null) {
                list = new ArrayList<String>();
                roomAndTime.put(key, list);
            }
            list.add(value);
        }

        private boolean hasClass(String time) {
            for (Map.Entry<String, ArrayList<String>> entry : roomAndTime.entrySet()) {
                for (String a : entry.getValue()) {
                    if (a == time) {
                        return true;
                    }
                }
            }
            return false;
        }

        public ArrayList<String> getTimeOfRoom(Room a) {
            return roomAndTime.get(a.getRoomName());
        }

        public ArrayList<String> getTimeOfRoom(int a) {
            return roomAndTime.get(Integer.toString(a));
        }

    }

    ArrayList<DayCalender> calStore;

    public Calendar() {
        calStore = new ArrayList<DayCalender>();
        calStore.add(new DayCalender(DAY.MONDAY));
        calStore.add(new DayCalender(DAY.TUESDAY));
        calStore.add(new DayCalender(DAY.WEDNESDAY));
        calStore.add(new DayCalender(DAY.THURSDAY));
        calStore.add(new DayCalender(DAY.FRIDAY));
        calStore.add(new DayCalender(DAY.SATERDAY));
        calStore.add(new DayCalender(DAY.SUNDAY));
    }
    
    public void add(DAY day, int time, int length)
    {
        
    }
}
