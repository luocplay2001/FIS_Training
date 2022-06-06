package core;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;


public class Detective {
    private Long detectiveId;
    private int version;
    private LocalDateTime cretedAt;
    private LocalDateTime modifiedAt;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime hiringDate;
    private String badgeNumber;
    private Rank rank;
    private Boolean armed;
    private EmploymentStatus status;
    private Set<CriminalCase> criminalCases;
    private Set<TrackEntry> trackEntries;

    public Detective() {
    }

    public Detective(Long detectiveId, int version
            , LocalDateTime cretedAt, LocalDateTime modifiedAt
            , String username, String firstName, String lastName
            , String password, LocalDateTime hiringDate,
                     String badgeNumber, Rank rank, Boolean armed
            , EmploymentStatus status, Set<CriminalCase> criminalCases
            , Set<TrackEntry> trackEntries) {
        this.detectiveId = detectiveId;
        this.version = version;
        this.cretedAt = cretedAt;
        this.modifiedAt = modifiedAt;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.hiringDate = hiringDate;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCases = criminalCases;
        this.trackEntries = trackEntries;
    }

    public Long getDetectiveId() {
        return detectiveId;
    }

    public void setDetectiveId(Long detectiveId) {
        this.detectiveId = detectiveId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCretedAt() {
        return cretedAt;
    }

    public void setCretedAt(LocalDateTime cretedAt) {
        this.cretedAt = cretedAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Boolean getArmed() {
        return armed;
    }

    public void setArmed(Boolean armed) {
        this.armed = armed;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public void setStatus(EmploymentStatus status) {
        this.status = status;
    }

    public Set<CriminalCase> getCriminalCases() {
        return criminalCases;
    }

    public void setCriminalCases(Set<CriminalCase> criminalCases) {
        this.criminalCases = criminalCases;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    @Override
    public String toString() {
        return "Detective{" +
                "detectiveId=" + detectiveId +
                ", version=" + version +
                ", cretedAt=" + cretedAt +
                ", modifiedAt=" + modifiedAt +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", hiringDate=" + hiringDate +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", rank=" + rank +
                ", armed=" + armed +
                ", status=" + status +
                ", criminalCases=" + criminalCases +
                ", trackEntries=" + trackEntries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detective detective = (Detective) o;
        return version == detective.version && Objects.equals(detectiveId, detective.detectiveId) &&
                Objects.equals(cretedAt, detective.cretedAt)
                && Objects.equals(modifiedAt, detective.modifiedAt)
                && Objects.equals(username, detective.username)
                && Objects.equals(firstName, detective.firstName)
                && Objects.equals(lastName, detective.lastName)
                && Objects.equals(password, detective.password)
                && Objects.equals(hiringDate, detective.hiringDate)
                && Objects.equals(badgeNumber, detective.badgeNumber)
                && rank == detective.rank && Objects.equals(armed, detective.armed)
                && status == detective.status && Objects.equals(criminalCases, detective.criminalCases)
                && Objects.equals(trackEntries, detective.trackEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detectiveId, version, cretedAt, modifiedAt, username
                , firstName, lastName, password, hiringDate, badgeNumber, rank, armed
                , status, criminalCases, trackEntries);
    }
}
