#!/bin/bash

TASKS_FILE="tasks.txt"
DELETED_FILE="deleted.txt"
COMPLETED_FILE="completed.txt"

show_menu(){
  echo "Welcome to TODO List"
  echo "1. Show Tasks"
  echo "2. Add new Task"
  echo "3. Show Removed Tasks"
  echo "4. Show Completed Tasks"
  echo "5. Add Pending Task to Completed"
  echo "6. Remove Tasks"
  echo "7. Exit"
}

add_task(){
  echo "Enter new Task (to exit, press Ctrl+D):"
  cat >> "$TASKS_FILE"
  echo "Task saved."
}

show_deleted_tasks(){
  echo "Deleted Tasks:"
  cat "$DELETED_FILE"
}

