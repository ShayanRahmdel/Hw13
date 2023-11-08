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

show_completed_tasks(){
  echo "Completed Tasks:"
  cat -n "$COMPLETED_FILE"
}

show_not_done_tasks(){
  echo "Not Done Tasks:"
  cat -n "$TASKS_FILE"
}

delete_task(){
  echo "Enter Task Number to Delete:"
  read task_number

  task=$(sed -n "${task_number}p" "$TASKS_FILE")
  sed -i "${task_number}d" "$TASKS_FILE"
  echo "$task" >> "$DELETED_FILE"
  echo "Task Deleted."
}
add_pending_to_completed(){
  echo "Enter Task Number to Add to Completed:"
  read task_number

  task=$(sed -n "${task_number}p" "$TASKS_FILE")
  sed -i "${task_number}d" "$TASKS_FILE"
  echo "$task" >> "$COMPLETED_FILE"
  echo "Task Added to Completed."
  }

