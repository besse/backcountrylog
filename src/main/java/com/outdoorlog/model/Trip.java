package com.outdoorlog.model;

import java.util.Date;
import java.util.List;

public class Trip {
    private com.outdoorlog.model.User leader;
    private List<com.outdoorlog.model.User> partyMembers;
    private com.outdoorlog.model.Destination destination;
    private Date startTime;
    private Date expectedEndTime;

}
