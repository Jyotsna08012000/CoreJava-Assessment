package coursemanagement;

public class Course {
	private int courseId,courseFees;
    private String courseName,courseDuration,courseDetails;
    
    public Course() {}
	
	public Course(int courseId, String courseName, int courseFees, String courseDuration, String courseDetails) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFees = courseFees;
		this.courseDuration = courseDuration;
		this.courseDetails = courseDetails;
		
		
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getCourseDetails() {
		return courseDetails;
	}
	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseFees=" + courseFees + ", courseName=" + courseName
				+ ", courseDuration=" + courseDuration + ", courseDetails=" + courseDetails + "]";
	}
	
	
}
	