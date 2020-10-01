# User Guide

Duke is an **desktop app for keeping track of tasks, optimised via a Command Line Interface (CLI)**.
The app allows you to add the tasks by the category with date, time and location, delete, finds
and mark the task as done.
Duke has an auto-saved feature that will automatically save the current task list
and export it to a text file. Upon start of the application, it will import the data 
from the text file and loads the task list back.

## 
### Quick start
1.  Ensure you have Java `11` or above installed in your Computer.

2.  Download the latest `duke.jar` from here.

3.  Copy the file to the folder you want to use as the home folder for your Duke.

4.  Double-click the file to start the app. The GUI similar to the below 
should appear in a few seconds. Note how the app contains some sample data.

5.  Type the command in the command box and press Enter to execute it. 
e.g. typing `bye` and pressing Enter, it will exit the program.
Some example commands you can try:
    *   `todo market research`: 
         Add a todo task with description "market research" to the task list.
         
    *   `find project`: 
         Find task contains the keyword "project" in the task list.  
            
    *   `list`: 
         Lists all the tasks.
         
    *   `delete 1`: 
         Delete the 1st task shown in the list.
         
    *   `done 1`: 
         Mark the 1st task shown in the list as done.  
             
6.  Refer to the Features below for details of each command.

## 
### Features 
   Notes about the command format
   * Words in UPPER_CASE are the parameters to be supplied by the user.
   e.g. in event DESCRIPTION /at TIME, TIME is a parameter which can be used as 
   `event project meeting /at 1pm-3pm`.
  
#### Adding a todo task: `todo`
Adds a todo task to the task list.

Format: `todo DESCRIPTION`

Examples: 
*   `todo market research`
*   `todo market survey`  
   
#### Adding a deadline task: `deadline`
Adds a deadline task to the task list.

Format: `deadline DESCRIPTION /by DATE`

Examples: 
*   `deadline powerpoint slide /by 7th April`
*   `deadline report /by 23th June`
 
#### Adding an event task: `event` 
Adds an event task to the task list. You can input TIME/LOCATION after "/at".

Format: `event DESCRIPTION /at TIME` OR `event DESCRIPTION /at LOCATION`

Examples: 
*   `event project meeting /at 1-3pm Monday`
*   `event project presentation /at `

#### Listing all tasks: `list`
Shows a list of all tasks in the task list.

Format: `list`


#### Deleting a task: `delete`
Deletes the specified task from the task list.

Format: `delete INDEX`

*   Deletes the task at the specified INDEX.
*   The index refers to the index number shown in the displayed task list.
*   The index must be a positive integer 1, 2, 3,

Examples:
*   `list` followed by `delete 2` deletes the 2nd task in the task list.

#### Locating task by description: `find` 
Find tasks whose description contain any of the given keywords.

Format: `find KEYWORD`

*   The search is case-sensitive.
*   Only the description is searched.
*   Tasks description containing the keyword will be returned

Examples:
*   `find project` returns `project meeting` and `project presentation`
*   `find market` returns `market research` and `market survey`
 
#### Marking a task as completed: `done`
Mark the specified task from the task list as done.

Format: `done INDEX`

*   Marks the task at the specified INDEX as done.
*   The index refers to the index number shown in the displayed task list.
*   The index must be a positive integer 1, 2, 3,

Examples:
*   `list` followed by `done 2` marks the 2nd task in the task list as done.

#### Exiting the program: `bye`
Exits the program.

Format: `bye`

#### Saving the date
Duke will auto-save the task list data in the hard disk after 
any command that changes the data. There is no need to save manually.

## 
### FAQ
**Q**: How do I transfer my data to another Computer?

**A**: Install the app in the other computer and overwrite the empty data file it creates with the file 
that contains the data of your previous Duke home folder.

## 
### Command summary
Action | Command 
-------|--------
**todo**| `todo DESCRIPTION` <br> e.g.,`todo market research`
**deadline**| `deadline DESCRIPTION /by DATE` <br> e.g.,`deadline powerpoint slide /by 7th April`
**event**| `event DESCRIPTION /at TIME` OR `event DESCRIPTION /at LOCATION` <br> e.g.,`event project meeting /at 1-3pm Monday`
**list**| `list` 
**done**| `done INDEX` <br> e.g.,`done 2`
**delete**| `delete INDEX` <br> e.g.,`delete 2`
**find**| `find KEYWORD` <br> e.g.,`find project`
**bye**| `bye` 