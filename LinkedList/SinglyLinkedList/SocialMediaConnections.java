class User {
    int userId;
    String name;
    int age;
    FriendNode friendList;
    User next;
    
    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}

class FriendNode {
    int friendId;
    FriendNode next;
    
    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class SocialNetwork {
    User head;
    
    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }
    
    User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    void addFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        
        if (user1 != null && user2 != null) {
            // Add user2 to user1's friend list
            FriendNode friend1 = new FriendNode(userId2);
            friend1.next = user1.friendList;
            user1.friendList = friend1;
            
            // Add user1 to user2's friend list
            FriendNode friend2 = new FriendNode(userId1);
            friend2.next = user2.friendList;
            user2.friendList = friend2;
        }
    }
    
    void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        
        if (user1 != null) {
            removeFriendFromList(user1, userId2);
        }
        if (user2 != null) {
            removeFriendFromList(user2, userId1);
        }
    }
    
    void removeFriendFromList(User user, int friendId) {
        if (user.friendList == null) return;
        
        if (user.friendList.friendId == friendId) {
            user.friendList = user.friendList.next;
            return;
        }
        
        FriendNode temp = user.friendList;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    
    void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        
        if (user1 == null || user2 == null) return;
        
        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        FriendNode temp1 = user1.friendList;
        while (temp1 != null) {
            if (isFriend(user2, temp1.friendId)) {
                User mutualFriend = findUser(temp1.friendId);
                if (mutualFriend != null) {
                    System.out.println("- " + mutualFriend.name);
                }
            }
            temp1 = temp1.next;
        }
    }
    
    boolean isFriend(User user, int friendId) {
        FriendNode temp = user.friendList;
        while (temp != null) {
            if (temp.friendId == friendId) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    void displayFriends(int userId) {
        User user = findUser(userId);
        if (user == null) return;
        
        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friendList;
        while (temp != null) {
            User friend = findUser(temp.friendId);
            if (friend != null) {
                System.out.println("- " + friend.name);
            }
            temp = temp.next;
        }
    }
    
    int countFriends(int userId) {
        User user = findUser(userId);
        if (user == null) return 0;
        
        int count = 0;
        FriendNode temp = user.friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class SocialMediaConnections {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 30);
        network.addUser(3, "Charlie", 28);
        network.addUser(4, "Diana", 26);
        
        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);
        network.addFriendConnection(2, 4);
        
        network.displayFriends(1);
        network.displayFriends(2);
        System.out.println();
        network.findMutualFriends(1, 2);
        System.out.println("Bob has " + network.countFriends(2) + " friends");
    }
}