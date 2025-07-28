import java.util.*;

abstract class JobRole {
    protected String roleName;
    protected List<String> requiredSkills;
    protected int experienceRequired;
    
    public JobRole(String roleName, List<String> requiredSkills, int experienceRequired) {
        this.roleName = roleName;
        this.requiredSkills = requiredSkills;
        this.experienceRequired = experienceRequired;
    }
    
    public String getRoleName() { return roleName; }
    public List<String> getRequiredSkills() { return requiredSkills; }
    public int getExperienceRequired() { return experienceRequired; }

    public String toString() {
        return roleName + " (Experience: " + experienceRequired + " years, Skills: " + requiredSkills + ")";
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", Arrays.asList("Java", "Python", "SQL", "Git"), 2);
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", Arrays.asList("Python", "R", "Machine Learning", "Statistics"), 3);
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", Arrays.asList("Strategy", "Analytics", "Communication", "Leadership"), 4);
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T targetRole;
    private List<String> skills;
    private int experience;
    private double matchScore;
    
    public Resume(String candidateName, T targetRole, List<String> skills, int experience) {
        this.candidateName = candidateName;
        this.targetRole = targetRole;
        this.skills = skills;
        this.experience = experience;
        this.matchScore = calculateMatchScore();
    }
    
    private double calculateMatchScore() {
        double skillMatch = 0;
        List<String> requiredSkills = targetRole.getRequiredSkills();
        
        for (String skill : skills) {
            if (requiredSkills.contains(skill)) {
                skillMatch++;
            }
        }
        
        double skillScore = (skillMatch / requiredSkills.size()) * 70; // 70% weight for skills
        double experienceScore = Math.min(experience / (double) targetRole.getExperienceRequired(), 1.0) * 30; // 30% weight for experience
        
        return skillScore + experienceScore;
    }
    
    public String getCandidateName() { return candidateName; }
    public T getTargetRole() { return targetRole; }
    public List<String> getSkills() { return skills; }
    public int getExperience() { return experience; }
    public double getMatchScore() { return matchScore; }
    
    @Override
    public String toString() {
        return candidateName + " applying for " + targetRole.getRoleName() + 
               " (Match Score: " + String.format("%.1f", matchScore) + "%)";
    }
}

public class AIResumeScreeningSystem {
    
    public static void screenResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("AI Resume Screening Results:");
        System.out.println("=" + "=".repeat(50));
        
        resumes.stream()
                .sorted((r1, r2) -> Double.compare(r2.getMatchScore(), r1.getMatchScore()))
                .forEach(resume -> {
                    System.out.println(resume);
                    String status = resume.getMatchScore() >= 70 ? "QUALIFIED" : 
                                   resume.getMatchScore() >= 50 ? "REVIEW" : "REJECTED";
                    System.out.println("Status: " + status);
                    System.out.println();
                });
    }
    
    public static <T extends JobRole> Resume<T> processResume(String name, T role, List<String> skills, int experience) {
        Resume<T> resume = new Resume<>(name, role, skills, experience);
        System.out.println("Processed: " + resume);
        return resume;
    }
    
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = processResume("Alice Johnson", new SoftwareEngineer(), 
                                                        Arrays.asList("Java", "Python", "Git", "Spring"), 3);
        
        Resume<DataScientist> resume2 = processResume("Bob Smith", new DataScientist(), 
                                                     Arrays.asList("Python", "Machine Learning", "SQL"), 2);
        
        Resume<ProductManager> resume3 = processResume("Carol Davis", new ProductManager(), 
                                                      Arrays.asList("Strategy", "Analytics", "Leadership", "Agile"), 5);
        
        Resume<SoftwareEngineer> resume4 = processResume("David Wilson", new SoftwareEngineer(), 
                                                        Arrays.asList("JavaScript", "HTML", "CSS"), 1);
        
        List<Resume<? extends JobRole>> allResumes = Arrays.asList(resume1, resume2, resume3, resume4);
        
        System.out.println("\n");
        screenResumes(allResumes);
    }
}