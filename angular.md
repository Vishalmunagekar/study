## Compilers used in angular
In Angular, the primary compilers used are the Just-in-Time (JIT) compiler and the Ahead-of-Time (AOT) compiler. Each of these compilers serves different purposes and is used in different stages of application development and deployment. Here's an overview of these compilers:
- **Just-in-Time (JIT) Compiler**
    - **Purpose** : JIT compilation is used during the development phase.
    - **Process**: The Angular application code is compiled in the browser at runtime. When the application is loaded, Angular compiles the TypeScript code and templates into JavaScript.
    - **Advantages** : 
        1. Faster development builds: Since JIT compilation happens at runtime, the build process is usually quicker.
        2. Easier debugging: Source maps are easier to use, and you can debug TypeScript directly.
    - **Disadvantages**: 
        1. Larger bundle size: Since the compiler is included in the bundle, the application size is larger.
        2. Slower initial load time: The application takes longer to start because the compilation happens in the browser.

- **Ahead-of-Time (AOT) Compiler**
    - **Purpose** : AOT compilation is used during the production phase.
    - **Process**: The application code is compiled at build time, before the browser downloads and runs the code. The templates and TypeScript code are converted to efficient JavaScript code during the build process.
    - **Advantages** : 
        1. Smaller bundle size: The compiler is not included in the bundle, resulting in a smaller application size.
        2. Faster initial load time: The application starts faster because the code is already compiled.
        3. Early error detection: Compilation errors are caught during the build process, reducing runtime errors.
        4. Improved security: Templates are pre-compiled, making it harder for attackers to inject malicious code.
    - **Disadvantages**: 
        1. Slower build process: AOT compilation takes more time during the build phase compared to JIT.

- **Choosing Between JIT and AOT**
    - **Development** : JIT is typically used for development because it provides faster build times and easier debugging. below command by default uses JIT compilation.
    ```sh
    ng serve
    ```
    - **Production** : AOT is preferred for production builds because it produces smaller bundles and improves the application's performance. Below command enables AOT compilation for the production build.
    ```sh
    ng build --prod
    ```
- **Other Tools and Concepts**
    - **Angular Ivy** : Ivy is Angular's next-generation compilation and rendering engine. With Ivy, both `JIT` and `AOT` have seen significant improvements in terms of build speed and bundle size.

        - Tree-shaking: Ivy enables better tree-shaking, resulting in smaller bundles by removing unused code.
        - Locality: Ivy compiles components independently, which improves incremental build times and reduces the complexity of the compilation process.
    - **Bazel** : Bazel is a build tool that can be used with Angular to manage large-scale applications. It allows for incremental builds and can significantly speed up the build process by only recompiling changed parts of the application.

## Directives in Angular
In Angular, directives are special markers on a DOM element (such as an attribute, element name, class, or comment) that tell Angular's compiler to attach a specified behavior to that DOM element. Directives are an essential feature of Angular as they allow you to extend HTML's capabilities and create reusable components.
- **Types of Directives**:
1. **Component Directives** : These are directives with a template. They are the most common type of directives and are used to create components.
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-example',
  template: '<h1>Hello, World!</h1>',
})
export class ExampleComponent {}
```
2. **Structural Directives** : Structural directives change the DOM layout by adding and removing DOM elements. They are denoted with an asterisk (*).
```typescript
<div *ngIf="isVisible">This is conditionally visible</div>

<ul>
  <li *ngFor="let item of items">{{ item }}</li>
</ul>

<div [ngSwitch]="value">
  <p *ngSwitchCase="'A'">Value is A</p>
  <p *ngSwitchCase="'B'">Value is B</p>
  <p *ngSwitchDefault>Value is something else</p>
</div>
```
3. **Attribute Directives** : Attribute directives change the appearance or behavior of an element, component, or another directive.
```typescript
<div [ngClass]="{'active': isActive, 'disabled': isDisabled}">Content</div>

<div [ngStyle]="{'font-size.px': fontSize, 'color': color}">Styled Content</div>

<div>
    <input [(ngModel)]="userName" placeholder="Enter your name">
    <p>Your name is {{ userName }}</p>
</div>
```
## 1. One-way Data Binding :
- One-way data binding will bind the data from the component to the view (DOM) or from view to the component.
- One-way data binding is unidirectional.
- You can only bind the data from component to the view or from view to the component.
	
* 1. Interpolation Binding: Interpolation refers to binding expressions into marked up language.
```html
		<strong>{{lastName}}</strong>
```
```typeScript
firstName: string = "Vishal";
```
* 2. Property Binding: Property binding is used to set a property of a view element.
The binding sets the property to the value of a template expression.
```HTML
	<button (click)="myFunction()">Show alert</button>
```
```typescript
		myFunction(): void { 
       		alert('Show alert!'); 
   		} 
```

* 3. Attribute Binding: Attribute binding is used to set a attribute property of a view element.
```html
	<span [innerHTML]='firstName'></span>
```		
* 4. Class Binding: Class binding is used to set a class property of a view element.
	
* 5. Style Binding: Style binding is used to set a style of a view element.
```HTML
		<h1 [style.color]="blue">This is a Blue Heading</h1>
```

## 2. Two-way Data Binding in Angular
- Two-way data binding in Angular will help users to exchange data from the component to view and from view to the component.

```html
	<input type="text" [(ngModel)] = 'val' />
```	
Before using ngModel to achieve two-way data binding, it’s very important to import the FormsModule from @angular/forms in app.module.ts file as shown below. FormsModule will contain the ngModule directive.

```TypeScript
	import { NgModule } from '@angular/core'; 
	import { FormsModule } from "@angular/forms";
```

## What is `trackBy` in angular ?
In Angular, `trackBy` is a mechanism used to optimize the rendering of list items in an `*ngFor` directive. By default, when Angular renders a list using `*ngFor`, it tracks list items by their object reference. This means that if the list changes, Angular will re-render the entire list, even if only one item changes, because it doesn't know which items have changed.

The `trackBy` function allows you to tell Angular how to track items in the list. By providing a custom `trackBy` function, you can specify a unique identifier (like an id or any other unique property) for each item, so Angular can keep track of which items have changed, been added, or removed. This results in more efficient DOM updates, as only the items that have actually changed will be re-rendered.
```ts
@Component({
  selector: 'app-item-list',
  template: `
    <ul>
      <li *ngFor="let item of items; trackBy: trackByFn">{{ item.name }}</li>
    </ul>
  `
})
export class ItemListComponent {
  items = [
    { id: 1, name: 'Item 1' },
    { id: 2, name: 'Item 2' },
    { id: 3, name: 'Item 3' }
  ];

  trackByFn(index: number, item: any): number {
    return item.id;
  }
}
```
### Explanation
- **Default Behavior**: Without trackBy, Angular would destroy and re-create all the DOM elements every time the list changes.
- **Using `trackBy`**: In the example above, `trackByFn` tells Angular to track the items by their id property. This way, if only one item changes or is added, Angular will only update the affected DOM elements, rather than the entire list.

*This can significantly improve performance, especially for large lists.*

## Angular Lifecycle Hooks

Certainly! Let’s go through each Angular lifecycle hook in more detail with example code. This will help solidify your understanding and prepare you for questions that might require you to discuss specific use cases or implementation details.

### 1. `ngOnChanges`
**Purpose**: Called when an input property changes. It is invoked before `ngOnInit` and whenever any data-bound input property changes.

**Example**:

```typescript
import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-child',
  template: `<p>{{data}}</p>`
})
export class ChildComponent implements OnChanges {
  @Input() data: string;

  ngOnChanges(changes: SimpleChanges) {
    console.log('ngOnChanges - data changed:', changes);
  }
}
```

- **Explanation**: The `ngOnChanges` method logs the changes made to the `data` input property whenever it is modified. The `SimpleChanges` object contains the current and previous value of the property.

### 2. `ngOnInit`
**Purpose**: Called once after the first `ngOnChanges`. It is typically used for component initialization.

**Example**:

```typescript
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-init-example',
  template: `<p>{{message}}</p>`
})
export class InitExampleComponent implements OnInit {
  message: string;

  ngOnInit() {
    this.message = 'Component initialized!';
    console.log('ngOnInit - Component has been initialized');
  }
}
```

- **Explanation**: The `ngOnInit` hook initializes the `message` property. It’s a great place for initial data fetching or setup logic.

### 3. `ngDoCheck`
**Purpose**: Called during every change detection cycle. It allows you to implement custom change detection logic.

**Example**:

```typescript
import { Component, DoCheck, Input } from '@angular/core';

@Component({
  selector: 'app-check-example',
  template: `<p>{{item}}</p>`
})
export class CheckExampleComponent implements DoCheck {
  @Input() item: string;

  ngDoCheck() {
    console.log('ngDoCheck - Change detection cycle');
  }
}
```

- **Explanation**: `ngDoCheck` is called on every change detection run. This is useful if you want to implement custom checks that are not handled by Angular’s default change detection.

### 4. `ngAfterContentInit`
**Purpose**: Called once after Angular projects external content into the component's view (after content children have been initialized).

**Example**:

```typescript
import { Component, AfterContentInit, ContentChild } from '@angular/core';

@Component({
  selector: 'app-content-child',
  template: `<ng-content></ng-content>`
})
export class ContentChildComponent implements AfterContentInit {
  @ContentChild('projectedContent') content;

  ngAfterContentInit() {
    console.log('ngAfterContentInit - Content has been projected:', this.content);
  }
}
```

- **Explanation**: This hook is useful when you want to access or manipulate projected content. `@ContentChild` allows you to reference the projected content inside the component.

### 5. `ngAfterContentChecked`
**Purpose**: Called after Angular checks the content projected into the component.

**Example**:

```typescript
import { Component, AfterContentChecked, ContentChild } from '@angular/core';

@Component({
  selector: 'app-content-checked',
  template: `<ng-content></ng-content>`
})
export class ContentCheckedComponent implements AfterContentChecked {
  @ContentChild('projectedContent') content;

  ngAfterContentChecked() {
    console.log('ngAfterContentChecked - Content has been checked:', this.content);
  }
}
```

- **Explanation**: `ngAfterContentChecked` is triggered after every change detection cycle when the projected content is checked. This is useful for any post-check logic.

### 6. `ngAfterViewInit`
**Purpose**: Called once after the component's view and child views have been initialized.

**Example**:

```typescript
import { Component, AfterViewInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-view-init',
  template: `<p #paragraphRef>View Initialized!</p>`
})
export class ViewInitComponent implements AfterViewInit {
  @ViewChild('paragraphRef') paragraph;

  ngAfterViewInit() {
    console.log('ngAfterViewInit - View initialized:', this.paragraph);
  }
}
```

- **Explanation**: This hook is ideal for interacting with or manipulating DOM elements or child components after the view has been fully initialized. `@ViewChild` is used to reference the element in the template.

### 7. `ngAfterViewChecked`
**Purpose**: Called after Angular checks the component's views and child views.

**Example**:

```typescript
import { Component, AfterViewChecked, ViewChild } from '@angular/core';

@Component({
  selector: 'app-view-checked',
  template: `<p #paragraphRef>View Checked!</p>`
})
export class ViewCheckedComponent implements AfterViewChecked {
  @ViewChild('paragraphRef') paragraph;

  ngAfterViewChecked() {
    console.log('ngAfterViewChecked - View checked:', this.paragraph);
  }
}
```

- **Explanation**: This hook runs after every change detection cycle when the view and child views are checked. It’s useful for post-view check logic, particularly when you need to ensure that certain UI updates have been applied.

### 8. `ngOnDestroy`
**Purpose**: Called just before Angular destroys the component or directive. It is typically used for cleanup.

**Example**:

```typescript
import { Component, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-destroy-example',
  template: `<p>Component will be destroyed!</p>`
})
export class DestroyExampleComponent implements OnDestroy {
  ngOnDestroy() {
    console.log('ngOnDestroy - Component is about to be destroyed');
    // Clean up code here, e.g., unsubscribing from observables
  }
}
```

- **Explanation**: `ngOnDestroy` is crucial for cleanup operations, such as unsubscribing from observables or detaching event listeners to prevent memory leaks.

### Putting It All Together

In an interview, you might be asked to demonstrate your understanding by describing a scenario where you would use several of these hooks together. For example:

```typescript
import { Component, OnInit, OnDestroy, OnChanges, DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit, AfterViewChecked, Input, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-lifecycle-example',
  template: `
    <ng-content></ng-content>
    <p #viewElement>Lifecycle Example Component</p>
  `
})
export class LifecycleExampleComponent implements OnInit, OnDestroy, OnChanges, DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit, AfterViewChecked {
  @Input() inputData: string;

  constructor() {
    console.log('Constructor - component is constructed');
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log('ngOnChanges - input data changed:', changes);
  }

  ngOnInit() {
    console.log('ngOnInit - component initialized');
  }

  ngDoCheck() {
    console.log('ngDoCheck - custom change detection');
  }

  ngAfterContentInit() {
    console.log('ngAfterContentInit - content initialized');
  }

  ngAfterContentChecked() {
    console.log('ngAfterContentChecked - content checked');
  }

  ngAfterViewInit() {
    console.log('ngAfterViewInit - view initialized');
  }

  ngAfterViewChecked() {
    console.log('ngAfterViewChecked - view checked');
  }

  ngOnDestroy() {
    console.log('ngOnDestroy - component destroyed');
  }
}
```

This example logs the lifecycle events, demonstrating how they are triggered in sequence as the component is created, updated, and destroyed. In an interview, you might be asked to describe this sequence or explain how you would use these hooks to manage component behavior effectively.

### Interview Perspective Tips
- **Why are lifecycle hooks important?** They are essential for controlling and managing the component's behavior at various stages of its existence, allowing for optimized resource management, clean code, and predictable application behavior.
- **Common Questions**: Be prepared to explain the sequence of these hooks, why and when you would use each one, and how they work together in a real-world scenario.
- **Advanced Scenarios**: You might be asked to compare or contrast hooks, especially around change detection (`ngOnChanges` vs. `ngDoCheck`), and how they can be used for performance optimization.

Understanding these hooks, their order of execution, and appropriate use cases will demonstrate a strong grasp of Angular’s component lifecycle, which is key in an interview setting.