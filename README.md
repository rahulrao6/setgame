
# SetGame - Interactive Card Game Application

## Overview
**SetGame** is an intricately designed card game, developed in Java, offering a unique blend of strategic gameplay and cognitive challenge. Drawing inspiration from the traditional "Set" card game, this application stands out with its two distinct modes, SetThree and GeneralSet, each tailored to provide a different level of complexity and engagement. Implemented using the Model-View-Controller (MVC) architecture, SetGame exemplifies a well-structured and scalable software design, making it an exemplary project for product management and software development portfolios.

## Key Features
- **Versatile Game Modes**: Offers two modes, SetThree for beginners and GeneralSet for advanced players, enhancing the game's appeal to a wide range of audiences.
- **Adaptive Grid Layout**: Supports dynamic grid sizes, adapting to different gameplay strategies and complexities.
- **Rich Card Attributes**: Each card is characterized by attributes such as count, filling, and shape, introducing a layer of strategy and depth to the gameplay.
- **Interactive User Experience**: Engages players with an intuitive command-line interface, elevating the traditional card game experience to a digital platform.
- **Sophisticated Game Logic**: Incorporates comprehensive rules for set formation, game progression, and dynamic grid adjustments, reflecting intricate game design and logical structuring.

## Game Mechanics
### SetThree
A beginner-friendly version featuring a 3x3 grid. Players identify sets based on three card attributes. It's an excellent mode for those new to the game, focusing on the fundamental mechanics of set identification.

### GeneralSet
An advanced variant played on a customizable grid. The game evolves by adding new rows when no sets are available, and it continues until the deck is depleted or no valid sets remain. This mode challenges experienced players with its ever-changing dynamics.

## Code Structure
- **Model (`cs3500.set.model`)**: The core logic and state management of the game. It includes `SetThreeGameModel` and `GeneralSetGameModel` in `hw02` and `hw03` packages, respectively, representing the two game variants.
- **View (`cs3500.set.view`)**: Manages the graphical representation of the game. The `SetGameTextView` class, implementing the `SetGameView` interface, provides a textual representation of the game board.
- **Controller (`cs3500.set.controller`)**: Bridges the model and view, managing game flow and user interactions. `SetGameControllerImpl` facilitates user input and updates the game state accordingly.

## Installation
This Java-based application requires no additional installation and is executed directly via the command line.

## How to Play
Run the `SetGameControllerImpl` main method to start the game. Follow the on-screen prompts to set grid dimensions and make moves. The game provides real-time feedback and updates via the command line, creating an engaging and interactive experience.

## Example of Game Initialization
```java
SetGameModel model = new SetThreeGameModel();
SetGameTextView view = new SetGameTextView(model, System.out);
SetGameController controller = new SetGameControllerImpl(model, view, new InputStreamReader(System.in));
controller.playGame();
```



This README is designed to provide a comprehensive understanding of the SetGame project, making it an ideal addition to your GitHub repository for potential collaborators and employers.
