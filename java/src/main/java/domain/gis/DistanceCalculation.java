package domain.gis;

public class DistanceCalculation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * 
     * 위경도 간의 거리를 계산해준다.
     * 
     * This routine calculates the distance between two points (given the latitude/longitude of those points). It is
     * being used to calculate the distance between two ZIP Codes or Postal Codes using our ZIPCodeWorld(TM) and
     * PostalCodeWorld(TM) products. Official Web site: http://www.zipcodeworld.com Hexa Software Development Center All
     * Rights Reserved 2004
     * 
     * @param lat1
     *            : Latitude of point 1 (in decimal degrees)
     * @param lon1
     *            : Longitude of point 1 (in decimal degrees)
     * @param lat2
     *            : Latitude of point 2 (in decimal degrees)
     * @param lon2
     *            : Longitude of point 2 (in decimal degrees)
     * @param unit
     *            : the unit you desire for results 'M' is statute miles 'K' is kilometers (default) 'N' is nautical
     *            miles
     * @return
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    /**
     * This function converts decimal degrees to radians
     * 
     * @param deg
     * @return
     */
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     * This function converts radians to decimal degrees
     * 
     * @param rad
     * @return
     */
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
