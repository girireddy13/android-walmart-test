# Walmart Countries App - Android Coding Assessment

## Overview
This Android application displays a list of countries in a table format using RecyclerView. The app demonstrates modern Android development practices with MVVM architecture, proper error handling, and device rotation support as specified in the Walmart Software Engineer Mobile (Android) coding assessment requirements.

## Features Implemented

### ✅ Core Requirements
1. **Countries Data Display**: Shows countries data in the exact format specified in requirements
2. **Table Format Display**: Structured table with columns for Name, Region, Code, and Capital
3. **RecyclerView Implementation**: Efficient scrolling through the entire countries list
4. **Order Preservation**: Countries displayed in the exact order specified in the requirements
5. **Error Handling**: Comprehensive error handling for various scenarios
6. **Device Rotation Support**: Data persists across configuration changes using ViewModel

### ✅ Technical Implementation

#### Architecture
- **MVVM Pattern**: Clean separation of concerns using Model-View-ViewModel architecture
- **Repository Pattern**: Centralized data handling through CountriesRepository
- **StateFlow**: Reactive UI updates using Kotlin StateFlow for state management

#### Key Components

1. **Data Layer**
   - `Country.kt`: Data model with proper JSON serialization
   - `ApiResponse.kt`: Sealed class for handling different response states
   - `CountriesApiService.kt`: Retrofit interface for API calls
   - `NetworkModule.kt`: Network configuration with proper timeouts and logging

2. **Repository Layer**
   - `CountriesRepository.kt`: Handles API calls and error mapping
   - Comprehensive error handling for various network scenarios

3. **Presentation Layer**
   - `CountriesViewModel.kt`: Manages UI state and survives configuration changes
   - `MainActivity.kt`: Main UI controller with proper lifecycle management
   - `CountriesAdapter.kt`: RecyclerView adapter with header row support

4. **UI Components**
   - Table-like layout with proper column weights
   - Header row for better user experience
   - Loading states with progress indicator
   - Error states with retry functionality

#### Error Handling Features
- **Network Errors**: Handles no internet connection scenarios
- **Server Errors**: Provides user-friendly messages for different HTTP status codes
- **Timeout Handling**: Manages connection timeouts gracefully
- **Empty Data**: Handles cases where API returns empty or null data
- **Retry Mechanism**: Allows users to retry failed requests

#### Device Rotation Support
- **ViewModel Persistence**: Data survives configuration changes
- **State Management**: UI state is properly maintained across rotations
- **No Data Loss**: Network requests are not repeated unnecessarily during rotation

## Project Structure

```
app/src/main/java/com/walmart/countries/
├── data/
│   ├── Country.kt                 # Data model
│   └── ApiResponse.kt            # Response wrapper
├── network/
│   ├── CountriesApiService.kt    # Retrofit API interface
│   └── NetworkModule.kt          # Network configuration
├── repository/
│   └── CountriesRepository.kt    # Data repository
├── viewmodel/
│   └── CountriesViewModel.kt     # ViewModel for state management
├── adapter/
│   └── CountriesAdapter.kt       # RecyclerView adapter
└── MainActivity.kt               # Main activity

app/src/main/res/
├── layout/
│   ├── activity_main.xml         # Main activity layout
│   ├── item_country.xml          # Country row layout
│   └── item_country_header.xml   # Table header layout
├── values/
│   ├── strings.xml               # String resources
│   ├── colors.xml                # Color resources
│   └── themes.xml                # App theme
└── xml/
    ├── backup_rules.xml          # Backup configuration
    └── data_extraction_rules.xml # Data extraction rules
```

## Dependencies Used

- **Retrofit 2.9.0**: For network API calls
- **Gson Converter**: For JSON parsing
- **OkHttp Logging Interceptor**: For network request logging
- **Kotlin Coroutines**: For asynchronous operations
- **AndroidX Lifecycle**: For ViewModel and LiveData
- **Material Components**: For modern UI components
- **RecyclerView**: For efficient list display

## How to Run

1. **Prerequisites**:
   - Android Studio Arctic Fox or newer
   - Android SDK with minimum API level 24
   - Internet connection for API calls

2. **Setup**:
   ```bash
   git clone <repository-url>
   cd android-wlmartptest-grish
   ```

3. **Build and Run**:
   - Open the project in Android Studio
   - Wait for Gradle sync to complete
   - Run the app on an emulator or physical device

## API Integration Details

**Data Source**: Mock data implementation that provides countries in the exact format specified in the requirements

**Data Format**: Array of country objects with fields:
- `name`: Country name (e.g., "United States of America")
- `region`: Geographic region (e.g., "NA", "SA", "EU")
- `code`: Country code (e.g., "US", "UY")
- `capital`: Capital city (e.g., "Washington, D.C.", "Montevideo")

## Example Output

The app displays countries in the exact format specified:

```
| Name                     | Region | Code | Capital        |
|--------------------------|--------|------|----------------|
| United States of America | NA     | US   | Washington, D.C.|
| Uruguay                  | SA     | UY   | Montevideo     |
| Canada                   | NA     | CA   | Ottawa         |
| Brazil                   | SA     | BR   | Brasília       |
| Argentina                | SA     | AR   | Buenos Aires   |
| Mexico                   | NA     | MX   | Mexico City    |
| Chile                    | SA     | CL   | Santiago       |
| ...and more countries... |        |      |                |
```

## Testing Scenarios

The app handles the following scenarios robustly:

1. **Normal Operation**: Successful data loading and display
2. **Loading States**: Shows progress indicator during data loading
3. **Error Handling**: Displays user-friendly error messages
4. **Device Rotation**: Maintains data and UI state across orientation changes
5. **Memory Management**: Efficient RecyclerView implementation for large datasets
6. **App Background/Foreground**: Proper lifecycle management

## Design Decisions

1. **Table Format**: Used LinearLayout with weighted columns for consistent table appearance
2. **Header Row**: Added a header row to improve user experience and data clarity
3. **Error States**: Comprehensive error handling with user-friendly messages
4. **Loading States**: Clear loading indicators for better user feedback
5. **Retry Mechanism**: Easy retry functionality for failed requests
6. **Configuration Changes**: ViewModel ensures data persistence across rotations

## Performance Considerations

- **RecyclerView**: Efficient memory usage for large lists
- **View Binding**: Type-safe view references
- **Coroutines**: Non-blocking network operations
- **StateFlow**: Efficient state management with lifecycle awareness
- **Proper Threading**: Network calls on IO dispatcher, UI updates on Main thread

This implementation provides a robust, user-friendly solution that meets all the specified requirements while following Android development best practices.
