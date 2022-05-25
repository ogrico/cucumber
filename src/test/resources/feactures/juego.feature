Feature: Funcionalidad de las opciones de Victoria, Derrota o Empate
  en el Juego Roca, Papel o Tijeras

  Scenario: El usuario gana cuando elige Piedra y la computadora elige Tijeras
    Given el jugador elige "piedra"
    And el computador elige "tijeras"
    When juegan
    Then el jugador gana

  Scenario: El usuario gana cuando elige Papel y la computadora elige Piedra
    Given el jugador elige "papel"
    And el computador elige "piedra"
    When juegan
    Then el jugador gana

  Scenario: El usuario gana cuando elige Tijeras y la computadora elige Papel
    Given el jugador elige "tijeras"
    And el computador elige "papel"
    When juegan
    Then el jugador gana

  Scenario: Empatan cuando eligen Piedra
    Given el jugador elige "piedra"
    And el computador elige "piedra"
    When juegan
    Then el jugador gana

  Scenario: Empatan cuando eligen Papel
    Given el jugador elige "papel"
    And el computador elige "papel"
    When juegan
    Then el jugador gana

  Scenario: Empatan cuando eligen Tijeras
    Given el jugador elige "tijeras"
    And el computador elige "tijeras"
    When juegan
    Then el jugador gana