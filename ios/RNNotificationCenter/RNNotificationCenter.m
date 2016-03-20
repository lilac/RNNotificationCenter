//
//  RNNotificationCenter.m
//  RNNotificationCenter
//
//  Created by James Deng on 20/03/2016.
//  Copyright © 2016 Rewen. All rights reserved.
//

#import "RNNotificationCenter.h"

@implementation NotificationManager

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(postNotification:(NSString *)name) {
    [[NSNotificationCenter defaultCenter] postNotificationName:name object:nil userInfo:nil];
}

@end
