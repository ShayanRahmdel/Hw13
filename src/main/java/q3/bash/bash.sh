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

