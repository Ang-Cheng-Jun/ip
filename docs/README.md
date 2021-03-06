# Duke User Guide

Duke is an **desktop app for keeping track of tasks, optimised via a Command Line Interface (CLI)**.
The app allows you to add the tasks by the category with date, time and location, delete, finds
and mark the task as done.
Duke has an auto-saved feature that will automatically save the current task list
and export it to a text file. Upon start of the application, it will import the data 
from the text file and loads the task list back.

## Table of Contents
* [Quick start](#quick-start)
* [Features](#features) 
  * [Adding a todo task: `todo`](#adding-a-todo-task-todo) 
  * [Adding a deadline task: `deadline`](#adding-a-deadline-task-deadline)
  * [Adding an event task: `event`](#adding-an-event-task-event)
  * [Listing all tasks: `list`](#listing-all-tasks-list)
  * [Deleting a task: `delete`](#deleting-a-task-delete)
  * [Finding tasks wth the keyword: `find`](#finding-tasks-with-the-keyword-find)
  * [Marking a task as done: `done`](#marking-a-task-as-done-done)
  * [Exiting The Program: `bye`](#exiting-the-program-bye)
  * [Saving the data](#saving-the-data)
* [Command summary](#command-summary)

## Quick start

1.  Ensure you have Java `11` or above installed in your Computer.

2.  Download the latest `duke.jar` from [here](https://github.com/Ang-Cheng-Jun/ip/releases/tag/v0.2).

3.  Copy the file to the folder you want to use as the home folder for your Duke.

4.  Open your command prompt as administrator. Then input java -jar **c:pathtojarfile.jar** in 
Command Prompt and press ENTER. Replace the **c:pathtojarfile.jar** with the actual path and 
file title of the Jar. The display similar to the below should appear in a few seconds.

    ![](images/Start%20Image.PNG)

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

## Features 

   **Notes about the command format**
    
   * Words in UPPER_CASE are the parameters to be supplied by the user.
    <br>e.g. in deadline DESCRIPTION /by DATE, DATE is a parameter which can be used as 
   `deadline project meeting /by 7th April`.

#### Adding a todo task: `todo`
Adds a todo task to the task list.

Format: `todo DESCRIPTION`

Examples: 
*   `todo market research`
*   `todo market survey`  

   ![](images/Todo%20Image.PNG)
<br/><br/>
#### Adding a deadline task: `deadline`
Adds a deadline task to the task list.

Format: `deadline DESCRIPTION /by DATE`

Examples: 
*   `deadline powerpoint slide /by 7th April`
*   `deadline report /by 23th June`

   ![](images/Deadline%20Image.PNG)
<br/><br/>
#### Adding an event task: `event` 
Adds an event task to the task list. You can input TIME/LOCATION after "/at".

Format: `event DESCRIPTION /at TIME` OR `event DESCRIPTION /at LOCATION`

Examples: 
*   `event project meeting /at 1-3pm Monday`
*   `event project presentation /at NUS`

   ![](images/Event%20Image.PNG)
<br/><br/>
#### Listing all tasks: `list`
Shows a list of all tasks in the task list.

Format: `list`

   ![](images/List%20Image.PNG)
<br/><br/>
#### Deleting a task: `delete`
Deletes the specified task from the task list.

Format: `delete INDEX`

*   Deletes the task at the specified INDEX.
*   The index refers to the index number shown in the displayed task list.
*   The index must be a positive integer 1, 2, 3,

Examples:
*   `list` followed by `delete 2` deletes the 2nd task in the task list.

   ![](images/Delete%20Image.PNG)
<br/><br/>
#### Finding tasks with the keyword: `find` 
Find tasks whose description contain the given keyword.

Format: `find KEYWORD`

*   The search is case-sensitive, and only accept one keyword.
*   Only the description is searched.
*   Tasks description containing the keyword will be returned

Examples:
*   `find project` returns `project meeting` and `project presentation`
*   `find market` returns `market research` and `market survey`

   ![](images/Find%20Image.PNG)
<br/><br/> 
#### Marking a task as done: `done`
Mark the specified task from the task list as done.

Format: `done INDEX`

*   Marks the task at the specified INDEX as done.
*   The index refers to the index number shown in the displayed task list.
*   The index must be a positive integer 1, 2, 3,

Examples:
*   `list` followed by `done 2` marks the 2nd task in the task list as done.

   ![](images/Done%20Image.PNG)
<br/><br/>
#### Exiting the program: `bye`
Exits the program.

Format: `bye`

   ![](images/Bye%20Image.PNG)
<br/><br/>
#### Saving the data
Duke will auto-save the task list data in the hard disk after 
any command that changes the data. There is no need to save manually.


## FAQ

**Q**: How do I transfer my data to another Computer?

**A**: Install the app in the other computer and overwrite the empty data file it creates with the file 
that contains the data of your previous Duke home folder.

## Command summary

| Format  | Usage | Example |
| --------- | ------ | ------- |
| **Todo** | `todo DESCRIPTION` | `todo market research` |
| **Deadline** | `deadline DESCRIPTION /by DATE` | `deadline powerpoint slide /by 7th April`|
| **Event** | `event DESCRIPTION /at TIME` or <br>`event DESCRIPTION /at LOCATION` | `event project meeting /at 1-3pm Monday` or <br> `event project presentation /at NUS` |
| **List** | `list` | `list` |
| **Delete** | `delete INDEX` | `delete 2` |
| **Find** | `find KEYWORD` | `find project` |
| **Done** | `done INDEX`| `done 2` |
| **Bye** | `bye` | `bye` |


