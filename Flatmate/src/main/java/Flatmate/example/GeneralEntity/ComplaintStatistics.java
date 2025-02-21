package Flatmate.example.GeneralEntity;

import java.util.Map;

public class ComplaintStatistics {
    private long totalComplaints;
    private long resolvedComplaints;
    private long unresolvedComplaints;
    private Map<String, Long> complaintsByType;

    // Constructors, Getters, and Setters

    public ComplaintStatistics(long totalComplaints, long resolvedComplaints, long unresolvedComplaints, Map<String, Long> complaintsByType) {
        this.totalComplaints = totalComplaints;
        this.resolvedComplaints = resolvedComplaints;
        this.unresolvedComplaints = unresolvedComplaints;
        this.complaintsByType = complaintsByType;
    }

    public long getTotalComplaints() {
        return totalComplaints;
    }

    public void setTotalComplaints(long totalComplaints) {
        this.totalComplaints = totalComplaints;
    }

    public long getResolvedComplaints() {
        return resolvedComplaints;
    }

    public void setResolvedComplaints(long resolvedComplaints) {
        this.resolvedComplaints = resolvedComplaints;
    }

    public long getUnresolvedComplaints() {
        return unresolvedComplaints;
    }

    public void setUnresolvedComplaints(long unresolvedComplaints) {
        this.unresolvedComplaints = unresolvedComplaints;
    }

    public Map<String, Long> getComplaintsByType() {
        return complaintsByType;
    }

    public void setComplaintsByType(Map<String, Long> complaintsByType) {
        this.complaintsByType = complaintsByType;
    }
}
