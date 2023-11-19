from tkinter import*
import random

# Define colors
colors = ['red', 'blue', 'green', 'yellow', 'orange', 'purple', 'pink', 'brown']

def start_game():
    label.config(text="", fg="black")
    chosen_color = random.choice(colors)
    label.config(text=chosen_color, fg=chosen_color)

def check_answer(guess):
    current_color = label.cget('text')
    if guess == current_color:
        result_label.config(text="Correct! 🎉", fg="green")
    else:
        result_label.config(text="Wrong! Try again. ❌", fg="red")

root = Tk()
root.title("Color Game")

label = Label(root, text="", font=("Arial", 40))
label.pack(pady=20)

for color in colors:
    btn = Button(root, text=color, width=8, command=lambda c=color: check_answer(c))
    btn.pack(pady=5)

start_button = Button(root, text="Start Game", command=start_game)
start_button.pack(pady=10)

result_label = Label(root, text="", fg="black")
result_label.pack(pady=10)

root.mainloop()