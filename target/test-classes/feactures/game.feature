Feature: Juego Roca, Papel o Tijeras

  Scenario: El usuario gana cuando elige Roca y la computadora elige Tijeras
    Given el jugador elige "ROCA"
    And el computador elige "TIJERAS"
    When el usuario juega
    Then verificar que la computadora eligio "TIJERAS"
    And el jugador gana