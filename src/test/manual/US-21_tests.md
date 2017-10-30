US-21 Manual GUI Tests

1. The GUI displays a discard pile that shows the last card drawn.
	Step 1: compile and run main
	Step 2: verify that one white panel is shown on the screen that is the discard pile 

	Pass: If the panel is shown
	Fail: if the panel is missing

2. When the draw pile is clicked, a new card is shown on the discard pile.
	Step 1: compile and run main
	Step 2: click the blue panel representing a facedown card
	Step 3: observe that a new card value is displayed on the discard pile

	Pass: if new card is shown (sometimes next card is the same as the last one, in which case you don't know for sure and should draw a new card)
	Fail: if the discard pile does not change when the draw pile is clicked
