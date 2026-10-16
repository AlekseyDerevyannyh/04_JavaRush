import os
import time

FILENAME = "dummy_file.txt"
LINES_PER_CYCLE = 200000  # Adjust number of lines for more I/O per cycle
RUN_SECONDS = 120  # The container keeps working long enough to watch it with docker stats


# Write the file and force the data to the disk instead of leaving it in the page cache
def write_file():
    with open(FILENAME, "w") as f:
        for i in range(LINES_PER_CYCLE):
            f.write(f"This is line {i}\n")
        f.flush()
        os.fsync(f.fileno())


# Drop the file from the page cache so that the next read goes to the disk
def drop_from_cache():
    fd = os.open(FILENAME, os.O_RDONLY)
    try:
        os.posix_fadvise(fd, 0, 0, os.POSIX_FADV_DONTNEED)
    finally:
        os.close(fd)


# Read the whole file back from the disk
def read_file():
    count = 0
    with open(FILENAME, "r") as f:
        for _ in f:
            count += 1
    return count


# Function to generate disk I/O operations: write and read the file in a loop
def generate_disk_io_operations():
    started = time.time()
    cycle = 0
    try:
        while time.time() - started < RUN_SECONDS:
            write_file()
            drop_from_cache()
            lines = read_file()
            cycle += 1
            print(f"Cycle {cycle}: wrote and read {lines} lines", flush=True)
    finally:
        if os.path.exists(FILENAME):
            os.remove(FILENAME)


generate_disk_io_operations()
