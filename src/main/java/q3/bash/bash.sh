#!/bin/bash

create_files() {
  for i in {1..5}; do
    touch "file$i.txt"
  done
  echo "Files created."
}

