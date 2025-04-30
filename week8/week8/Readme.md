# Task Management System Documentation

## Step 1: Method Extraction

**Task**
- `Task(String title, LocalDate dueDate)`
- `String getTitle()`
- `LocalDate getDueDate()`
- `boolean isCompleted()`
- `boolean isOverdue()`
- `void markCompleted()`

**User**
- `User(String username, String email)`
- `String getUsername()`
- `String getEmail()`
- `void addTask(Task task)`
- `void removeTask(Task task)`
- `boolean hasTask(Task task)`
- `List<Task> getTasks()`

**Project**
- `void addUser(User user)`
- `void addTask(Task task)`
- `Optional<Task> getTaskByTitle(String title)`
- `Set<User> getUsers()`
- `List<Task> getTasks()`

**NotificationService**
- `void sendNotification(User user, String message)`
- `List<String> getNotifications(User user)`

**TaskManager**
- `TaskManager(NotificationService notificationService)`
- `void assignTask(User user, Task task)`
- `void removeTask(User user, Task task)`
- `List<Task> listTasks(User user)`

## Step 2: Specification Writing

### Task

- **`Task(String title, LocalDate dueDate)`**
    - **Requires:** `title != null && !title.isEmpty()`, `dueDate != null`
    - **Effects:** Creates a new Task instance with `completed == false`.

- **`String getTitle()`**
    - **Requires:** Task object exists
    - **Effects:** Returns the task title.

- **`LocalDate getDueDate()`**
    - **Requires:** Task object exists
    - **Effects:** Returns the due date.

- **`boolean isCompleted()`**
    - **Requires:** Task object exists
    - **Effects:** Returns the completion status.

- **`boolean isOverdue()`**
    - **Requires:** Task object exists; `dueDate` defined
    - **Effects:** Returns `true` if `!completed && LocalDate.now().isAfter(dueDate)`, else `false`.

- **`void markCompleted()`**
    - **Requires:** Task object exists
    - **Effects:** Sets `completed = true`.

### User

- **`User(String username, String email)`**
    - **Requires:** `username != null && !username.isEmpty()`, `email != null && !email.isEmpty()`
    - **Effects:** Creates a new User with an empty task list.

- **`String getUsername()`**, **`String getEmail()`**
    - **Requires:** User object exists
    - **Effects:** Returns username or email respectively.

- **`void addTask(Task task)`**
    - **Requires:** `task != null`, not already in user's task list
    - **Effects:** Adds the task to the user's list.

- **`void removeTask(Task task)`**
    - **Requires:** `task != null`, present in user's task list
    - **Effects:** Removes the task from the list.

- **`boolean hasTask(Task task)`**
    - **Requires:** `task != null`
    - **Effects:** Returns `true` if the task is in the list.

- **`List<Task> getTasks()`**
    - **Requires:** User object exists
    - **Effects:** Returns an unmodifiable copy of the task list.

### Project

- **`void addUser(User user)`**
    - **Requires:** `user != null`, not already added
    - **Effects:** Adds the user to the project.

- **`void addTask(Task task)`**
    - **Requires:** `task != null`, not already added
    - **Effects:** Adds the task to the project.

- **`Optional<Task> getTaskByTitle(String title)`**
    - **Requires:** `title != null`
    - **Effects:** Returns the first matching task wrapped in Optional, or `Optional.empty()`.

- **`Set<User> getUsers()`**, **`List<Task> getTasks()`**
    - **Requires:** —
    - **Effects:** Returns unmodifiable copies of the user set or task list.

### NotificationService

- **`void sendNotification(User user, String message)`**
    - **Requires:** `user != null`, `message != null`
    - **Effects:** Appends the message to the user's notification list.

- **`List<String> getNotifications(User user)`**
    - **Requires:** `user != null`
    - **Effects:** Returns an unmodifiable copy of the user's notifications.

### TaskManager

- **`TaskManager(NotificationService notificationService)`**
    - **Requires:** `notificationService != null`
    - **Effects:** Constructs a TaskManager with the given service.

- **`void assignTask(User user, Task task)`**
    - **Requires:** `user != null`, `task != null`, `!user.hasTask(task)`
    - **Effects:** Calls `user.addTask(task)` then sends a notification.

- **`void removeTask(User user, Task task)`**
    - **Requires:** `user != null`, `task != null`, `user.hasTask(task)`
    - **Effects:** Removes the task via `user.removeTask(task)`.

- **`List<Task> listTasks(User user)`**
    - **Requires:** `user != null`
    - **Effects:** Returns `user.getTasks()`.

