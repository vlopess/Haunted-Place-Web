import {animate, keyframes, query, state, style, transition, trigger} from '@angular/animations';

export const shownStateTrigger = trigger('dialogAnimation', [
    state('void', style({ opacity: 0, transform: 'scale(0.9)' })),
    state('*', style({ opacity: 1, transform: 'scale(1)' })),
    transition(':enter', [
        animate('300ms ease-out')
    ]),
    transition(':leave', [
        animate('200ms ease-in')
    ])
]);

export const shakeTrigger = trigger('shakeAnimation', [
    transition('* => *', [
        query('input.ng-invalid:focus, select.ng-invalid:focus', [
            animate('0.5s', keyframes([
                style({ border: '2px solid red'}),
                style({ transform: 'translateX(0)'}),
                style({ transform: 'translateX(-10px)'}),
                style({ transform: 'translateX(10px)'}),
                style({ transform: 'translateX(-10px)'}),
                style({ transform: 'translateX(10px)'}),
                style({ transform: 'translateX(-10px)'}),
                style({ transform: 'translateX(10px)'}),
                style({ transform: 'translateX(0)'}),
            ]))
        ])
    ])
])