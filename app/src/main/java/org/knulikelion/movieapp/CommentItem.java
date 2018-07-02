package org.knulikelion.movieapp;

public class CommentItem  {
        String name;
        String time;
        String summary;
        int resID;

        public CommentItem(String name, String time, String summary, int resID) {
            this.name = name;
            this.time = time;
            this.summary = summary;
            this.resID = resID;
        }

        public int getResID() {
            return resID;
        }

        public void setResID(int resID) {
            this.resID = resID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSummary() {
            return summary;
         }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        @Override
        public String toString() {
            return "SingerItem{" +
                    "name='" + name + '\'' +
                    ", time='" + time + '\'' +
                    ", summary='" + summary + '\'' +
                    '}';
        }
}
