# DialogueAPI
A Sponge-Vanilla based dialogue API

A Dialogue is made up of a list of Displayable's. Displayable's come in 2 kinds: Sentences and ChoiceWheels. A sentence should be used for when an NPC is talking to the player. A ChoiceWheel should be used when giving the player some sort of decision to make. ChoiceWheels are made up of Choices. Choices are basically just Sentences with a DialogueAction linked to each Choice. DialogueActions can do things such as continuing other dialogues. For instance:

Old Man: Hello! Can you help me? (Sentence)

-Yes
-No
-With what? (These three are all part of one ChoiceWheel)

If "yes" is clicked, it would initiate a quest via a DialogueAction. If "no" is clicked, it could initiate another Dialogue that's pretty much a dead sentence. If "with what?" is clicked, it could initiate another Dialogue followed by another ChoiceWheel.

1) New Quest: Old Man's Glasses
2) Old Man: "Oh, okay. Come back when you have the time!" (with no preceeding ChoiceWheel so this is just a closer sentence) 
3)Old Man: "Well I've lost my glasses over by the lake. Will you help me find them?"

- Of course
- I don't have time right now (another ChoiceWheel)
