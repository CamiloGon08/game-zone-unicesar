# Version Control — GameZone Unicesar (Technical Lead)

This document consolidates the version control activity of the Technical Lead (Camilo Andres Gonzalez Garcia) for the GameZone Unicesar project. It includes the branching strategy, branches created, commit log attributed to the Technical Lead, and a quantitative summary. It is generated from the actual state of the repository (git log, git shortlog, and git branch).

## Branching Strategy

The project follows a simplified Git Flow:

- `main` — protected, stable. Only receives merges from `develop` via Pull Request.
- `develop` — protected, integration branch. Receives merges from `feature/*` branches via Pull Request.
- `feature/*` — temporary branches, one per functional unit. Branches from `develop`, merges back into `develop`, and is deleted after merge.

Both `main` and `develop` have branch protection enabled on GitHub:

| Setting | main | develop |
|:---|:---|:---|
| Force pushes allowed | No | No |
| Branch deletion allowed | No | No |
| Required approving reviews | 0 | 0 |

## Branches Created

The following branches were created during the project:

| Branch | Purpose | Status |
|:---|:---|:---|
| `main` | Stable release branch | Active |
| `develop` | Integration branch | Active |
| `feature/sale-module` | Sale module, UI and Main (Technical Lead) | Active |
| `fix/package-structure` | Package structure fixes | Active |
| `feature/person-module` | Person module (Developer 2) | Active |
| `feature/product-module` | Product module (Developer 1) | Active |

## Commits by Technical Lead

The Technical Lead (Camilo Andres Gonzalez Garcia) has two git identities:
- `Camilo Andres Gonzalez Garcia` — local git commits
- `CamiloGon08` — GitHub account (merge commits via Pull Requests)

### Commits attributed to Camilo Andres Gonzalez Garcia (19 commits)

| Hash | Date | Message |
|:---|:---|:---|
| d121f35 | 2026-09-04 | chore: configure Maven project structure for four layers |
| 1e14d0d | 2026-09-06 | feat: implement Sale class with total calculation |
| a2f5a47 | 2026-09-06 | feat: implement Salepository for persistence |
| 837a6bc | 2026-09-06 | feat: add method to convert sale objects into text format |
| 99b611a | 2026-09-06 | feat: implement save method in SaleRepository |
| 55556d2 | 2026-09-06 | feat: implement SaleService class with validation rules |
| 5e40aa5 | 2026-09-08 | fix: correct package and resolve compilation errors in product module |
| beccc37 | 2026-09-09 | fix: correct package structure and resolve Sale class compilation errors |
| 7553b24 | 2026-09-09 | feat: add SaleService with registerSale method and stock validation |
| ae3f230 | 2026-09-09 | feat: add register and query methods to SaleService |
| d83536f | 2026-09-09 | feat: create ConsoleMenu class with service dependencies |
| 1ecf5ff | 2026-09-09 | feat: add main menu loop and print method with 10 options |
| dfd6832 | 2026-09-09 | feat: add registerVideoGame and registerConsole methods |
| 951d2cc | 2026-09-09 | feat: add all remaining console menu operations |

### Commits attributed to CamiloGon08 (5 commits)

| Hash | Date | Message |
|:---|:---|:---|
| f9e6ef7 | 2026-09-04 | Initial commit |
| c86413d | 2026-09-04 | Merge pull request #1 from CamiloGon08/feature/sale-module |
| 5f1c69a | 2026-09-08 | Merge pull request #4 from CamiloGon08/feature/sale-module |
| 0fb4090 | 2026-09-08 | Merge pull request #6 from CamiloGon08/fix/package-structure |
| 64bf995 | 2026-09-09 | Merge pull request #5 from CamiloGon08/feature/person-module |

**Total commits by Technical Lead: 19**

## Quantitative Summary

| Metric | Value |
|:---|:---|
| Total commits (Technical Lead) | 19 |
| Feature branches created | 1 (`feature/sale-module`) |
| Pull Requests merged | 4 (PR #1, #4, #5, #6) |

## Notes

- The Technical Lead exceeded the minimum requirement of 12 commits.
- All Pull Requests were merged using the GitHub account `CamiloGon08`.
- The `feature/sale-module` branch remains active and contains the implementation of the sale module, console UI, and application entry point.
- Branch protection rules are enforced on `main` and `develop`.