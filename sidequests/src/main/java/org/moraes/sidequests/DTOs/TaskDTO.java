package org.moraes.sidequests.DTOs;


import org.moraes.sidequests.enums.Identifier;

import java.util.UUID;

public record TaskDTO(
   String name,
   String description,
   Boolean completed,
   UUID id,
   Identifier identifier
) {}
