import tkinter as tk
from tkinter import messagebox

def add_task():
    task = entry.get()
    if task:
        listbox.insert(tk.END, task)
        entry.delete(0, tk.END)
    else:
        messagebox.showwarning("Warning", "Please enter a Note.")

def remove_task():
    selected_task_index = listbox.curselection()
    if selected_task_index:
        listbox.delete(selected_task_index)
    else:
        messagebox.showwarning("Warning", "Please select a note to remove.")

# Create the main window
root = tk.Tk()
root.title("stickey Note")

# Create widgets
entry = tk.Entry(root, width=40)
add_button = tk.Button(root, text="Add Note", command=add_task)
remove_button = tk.Button(root, text="Remove Note", command=remove_task)
listbox = tk.Listbox(root, selectmode=tk.SINGLE, height=10, width=80)

# Place widgets on the window
entry.pack(pady=10)
add_button.pack(pady=5)
remove_button.pack(pady=5)
listbox.pack(pady=10)

# Run the main loop
root.mainloop()