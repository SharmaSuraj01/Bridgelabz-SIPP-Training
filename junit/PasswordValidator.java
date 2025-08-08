public class PasswordValidator {
    
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        
        return hasUppercase && hasDigit;
    }
}