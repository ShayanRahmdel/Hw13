#!/bin/bash

create_files() {
  for i in {1..5}; do
    touch "file$i.txt"
  done
  echo "Files created."
}

add_text_to_files() {
  for file in file*.txt; do
    echo "Hello world" >> "$file"
  done
  echo "Text added to files."
}

replace_world_with_bash() {
  for file in file*.txt; do
    sed -i 's/world/bash/g' "$file"
  done
  echo "Word 'world' replaced with 'bash'."
}

show_menu() {
  PS3="Select an option: "
  select option in "Create Files" "Add Text to Files" "Replace 'world' with 'bash'" "Exit"; do
    case $option in
      "Create Files")
        create_files
        ;;
      "Add Text to Files")
        add_text_to_files
        ;;
      "Replace 'world' with 'bash'")
        replace_world_with_bash
        ;;
      "Exit")
        echo "Exiting."
        exit 0
        ;;
      *)
        echo "Invalid option. Please select again."
        ;;
    esac
  done
}

show_menu